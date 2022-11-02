import {IKhachHang} from './i-khach-hang';


export interface ISoTietKiem {
  id?: number;
  khachHang?: IKhachHang;
  ngayMoSo?: string;
  ngayGui?: string;
  kyHan?: number;
  tienGui?: number;
  laiSuat?: number;
  uuDai?: string;
}
