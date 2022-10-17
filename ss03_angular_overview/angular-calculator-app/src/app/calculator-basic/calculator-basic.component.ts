import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator-basic',
  templateUrl: './calculator-basic.component.html',
  styleUrls: ['./calculator-basic.component.css']
})
export class CalculatorBasicComponent implements OnInit {
  firstNumber: number;
  secondNumber: number;
  result: any;

  constructor() {
  }

  ngOnInit(): void {
    this.firstNumber = 0;
    this.secondNumber = 0;
  }

  sumTwoNumber() {
    this.result = Number(this.firstNumber) + Number(this.secondNumber);
  }

  subtractionTwoNumber() {
    this.result = Number(this.firstNumber) - Number(this.secondNumber);
  }

  multiplicationTwoNumber() {
    this.result = Number(this.firstNumber) * Number(this.secondNumber);
  }

  divisionTwoNumber() {
    // tslint:disable-next-line:triple-equals
    if ((Number(this.secondNumber)) != 0) {
      this.result = Number(this.firstNumber) / Number(this.secondNumber);
    } else {
      this.result = 'Không được chia cho 0!';
    }
  }
}
