import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SoTietKiemService} from '../service/so-tiet-kiem.service';
import {ActivatedRoute, Router} from '@angular/router';
import {ISoTietKiem} from '../i-so-tiet-kiem';

@Component({
  selector: 'app-tao-moi-so-tiet-kiem',
  templateUrl: './tao-moi-so-tiet-kiem.component.html',
  styleUrls: ['./tao-moi-so-tiet-kiem.component.css']
})
export class TaoMoiSoTietKiemComponent implements OnInit {
  formGroupSoTietKiem: FormGroup = new FormGroup(
    {
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
              private router: Router
  ) {
  }

  ngOnInit(): void {
  }
  giveFormValue() {
    const soTietKiem: ISoTietKiem = this.formGroupSoTietKiem.value;
    // alert(this.titleCasePipe.transform(soTietKiem.khachHang.ten));
    console.log(soTietKiem);
    this.soTietKiemService.createInfo(soTietKiem).subscribe(v => {
      alert('update thành công');
      this.router.navigateByUrl('tietkiem');
    });
  }
}
