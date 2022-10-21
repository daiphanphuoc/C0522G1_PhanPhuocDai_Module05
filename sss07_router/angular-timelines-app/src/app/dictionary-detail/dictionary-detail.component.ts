import { Component, OnInit } from '@angular/core';
import {IWord} from '../model/i-word';
import {FormGroup} from '@angular/forms';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {DictionaryService} from '../service/dictionary.service';

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {

  details: IWord;

  constructor(private activatedRoute: ActivatedRoute,
              private dictionaryService: DictionaryService) {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const word = paramMap.get('key');
      this.details = this.dictionaryService.getById(word);
    });
  }

  ngOnInit(): void {}
}
