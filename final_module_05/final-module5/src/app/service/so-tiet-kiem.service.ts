import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Observable} from 'rxjs';
import {ISoTietKiem} from '../i-so-tiet-kiem';
import {SearchResult} from '../search-result';
import {ISoTietKiemDto} from '../i-so-tiet-kiem-dto';

@Injectable({
  providedIn: 'root'
})
export class SoTietKiemService {

  constructor(private httpClient: HttpClient) {
  }

  paginate(page: number, limit: number): Observable<SearchResult<ISoTietKiemDto>> {

    const URL = environment.api_url + '/soTietKiems?page=' + (page - 1) + '&size=' + limit;
    console.log(URL);
    return this.httpClient.get<SearchResult<ISoTietKiemDto>>(URL);
  }

  deleteSoTietKiem(id: number): Observable<void> {
    return this.httpClient.delete<void>(environment.api_url + '/soTietKiems/' + id);
  }

  getById(id: number): Observable<ISoTietKiemDto> {
    return this.httpClient.get<ISoTietKiemDto>(environment.api_url + '/soTietKiems/' + id);
  }

  updateInfo(soTietKiemDto: ISoTietKiem): Observable<void> {
    alert(environment.api_url + '/soTietKiems/' + soTietKiemDto.id);
    return this.httpClient.patch<void>(environment.api_url + '/soTietKiems/update/' + soTietKiemDto.id, soTietKiemDto);
  }

  createInfo(soTietKiemDto: ISoTietKiem): Observable<void> {
    return this.httpClient.post<void>(environment.api_url + '/soTietKiems', soTietKiemDto);
  }
}
