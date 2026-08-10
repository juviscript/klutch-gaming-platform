import { Component } from '@angular/core';
import { Hero } from '../../components/hero/hero';
import { Collection } from '../../components/collection/collection';
import { PromiseSection } from '../../components/promise/promise';

@Component({
  selector: 'app-home',
  imports: [Hero, Collection, PromiseSection],
  templateUrl: './home.html',
})
export class Home {}
