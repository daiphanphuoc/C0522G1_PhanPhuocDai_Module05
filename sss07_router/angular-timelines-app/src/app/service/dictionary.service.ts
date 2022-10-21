import {Injectable} from '@angular/core';
import {IWord} from '../model/i-word';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionaryList: IWord[] = [
    {word: 'green', mean: 'xanh lá'},
    {word: 'table', mean: 'bảng'},
    {word: 'dictionary', mean: 'từ điển'},
    {word: 'book', mean: 'sách'},
    {word: 'app', mean: 'ứng dụng'},
    {word: 'product', mean: 'sản phẩm'},
  ];

  constructor() {
  }

  getAll(): IWord[] {
    return this.dictionaryList;
  }

  getById(key: string): IWord {
    return this.dictionaryList.find(iWord => iWord.word === key);
  }
}
