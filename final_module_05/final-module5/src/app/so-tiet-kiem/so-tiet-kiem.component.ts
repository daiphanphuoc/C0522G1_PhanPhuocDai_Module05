import {Component, OnInit} from '@angular/core';
import {BehaviorSubject, Observable} from 'rxjs';
import {ISoTietKiem} from '../i-so-tiet-kiem';
import {SoTietKiemService} from '../service/so-tiet-kiem.service';
import {FormControl, FormGroup} from '@angular/forms';
import {DatePipe, TitleCasePipe} from '@angular/common';
import {ISoTietKiemDto} from '../i-so-tiet-kiem-dto';


@Component({
  selector: 'app-so-tiet-kiem',
  templateUrl: './so-tiet-kiem.component.html',
  styleUrls: ['./so-tiet-kiem.component.css']
})
export class SoTietKiemComponent implements OnInit {
  page = 1;
  pageSize = 4;
  soTietKiems$: Observable<ISoTietKiemDto[]>;
  total$: Observable<number>;
  id: number;
  tenKhach: string;

  deleteForm: FormGroup = new FormGroup({
      id: new FormControl()
    }
  );
  msg: string;
  ten: string;
  totalPage$: Observable<number>;

  constructor(private soTietKiemService: SoTietKiemService) {
  }

  ngOnInit(): void {
    this.paginate();
  }

  paginate() {
    this.soTietKiemService.paginate(this.page, this.pageSize).subscribe(data => {
      console.log(data);
      this.soTietKiems$ = new BehaviorSubject<ISoTietKiem[]>(data.content);
      this.total$ = new BehaviorSubject<number>(data.totalElements);
      this.totalPage$ = new BehaviorSubject<number>(data.totalPages);
    });
  }

  infoDelete(id: number, ten: string) {
    this.msg = '';
    // alert(this.titleCasePipe.transform(ten));
    this.deleteForm.controls.id.setValue(id);
    this.ten = ten;
    // this.deleteForm.controls.name.setValue(ten);
  }

  deleteSoTietKiem() {
    const id = +this.deleteForm.value.id;
    this.soTietKiemService.deleteSoTietKiem(id).subscribe(() => {
      this.paginate();
      this.msg = 'Xóa thành công';
    });
  }

  previous() {
    if (this.page > 1) {
      this.page--;
      this.paginate();

    }
  }

  next() {
    this.page++;
    this.paginate();
  }

  getPaginate() {
    this.page = 1;
    this.paginate();
  }
}
