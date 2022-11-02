import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SoTietKiemService} from '../service/so-tiet-kiem.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ISoTietKiem} from '../i-so-tiet-kiem';
import {DatePipe, TitleCasePipe} from '@angular/common';
import {IKhachHang} from '../i-khach-hang';
import {ISoTietKiemDto} from '../i-so-tiet-kiem-dto';

@Component({
  selector: 'app-sua-so-tiet-kiem',
  templateUrl: './sua-so-tiet-kiem.component.html',
  styleUrls: ['./sua-so-tiet-kiem.component.css']
})
export class SuaSoTietKiemComponent implements OnInit {
  formGroupSoTietKiem: FormGroup = new FormGroup(
    {
      id: new FormControl(),
      ngayMoSo: new FormControl('', Validators.required),
      ngayGui: new FormControl('', Validators.required),
      kyHan: new FormControl('', Validators.required),
      tienGui: new FormControl('', Validators.required),
      laiSuat: new FormControl('', Validators.required),
      uuDai: new FormControl(),
      khachHang: new FormGroup({
        id: new FormControl(),
        ten: new FormControl('', [Validators.required, Validators.pattern('^[a-zA-Z ]+$')])
      }),


    }
  );
  kyHan: number[] = [6, 9, 12];

  constructor(private soTietKiemService: SoTietKiemService,
              private activateRoute: ActivatedRoute,
              private router: Router
  ) {
  }

  ngOnInit(): void {
    this.getSoTietKiem();
  }

  getSoTietKiem() {
    this.activateRoute.paramMap.subscribe(v => {

      const id = +v.get('id');
      this.soTietKiemService.getById(id).subscribe(value => {

        const item: ISoTietKiem = value;

        const khachHang: IKhachHang = {id: value.id, ten: value.ten};
        // const element: ISoTietKiemDto = value;
        item.khachHang = khachHang;
        this.formGroupSoTietKiem.patchValue(item);
      });
    });
  }

  giveFormValue() {
    const soTietKiem: ISoTietKiem = this.formGroupSoTietKiem.value;
    // alert(this.titleCasePipe.transform(soTietKiem.khachHang.ten));
    console.log(soTietKiem);
    this.soTietKiemService.updateInfo(soTietKiem).subscribe(v => {
      alert('update thành công');
      this.router.navigateByUrl('tietkiem');
    });
  }
}
