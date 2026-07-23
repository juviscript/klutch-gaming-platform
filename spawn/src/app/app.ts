import { Component } from '@angular/core';
import { Nav } from './components/nav/nav';
import { Hero } from './components/hero/hero';
import { Collection } from './components/collection/collection';
import { PromiseSection } from './components/promise/promise';
import { Footer } from './components/footer/footer';

@Component({
  selector: 'app-root',
  imports: [Nav, Hero, Collection, PromiseSection, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {}
