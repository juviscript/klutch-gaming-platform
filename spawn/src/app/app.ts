import { Component, inject } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import { DOCUMENT } from '@angular/common';
import { NavigationEnd, Router, RouterOutlet } from '@angular/router';
import { filter } from 'rxjs';
import { Nav } from './components/nav/nav';
import { Footer } from './components/footer/footer';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Nav, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App {
  private readonly document = inject(DOCUMENT);
  private readonly router = inject(Router);

  constructor() {
    // Toggling the snap-scroll class and resetting scroll position must happen
    // synchronously together, in that order: scroll-snap-type must already be off
    // before we jump to the top, otherwise the browser snaps to the nearest actual
    // snap point on the new page instead of true 0 (an effect()-based class toggle
    // runs on a later scheduling tick than this and is too late to prevent that).
    this.router.events
      .pipe(
        filter((event): event is NavigationEnd => event instanceof NavigationEnd),
        takeUntilDestroyed(),
      )
      .subscribe((event) => {
        const isHome = event.urlAfterRedirects === '/' || event.urlAfterRedirects.startsWith('/#');
        this.document.documentElement.classList.toggle('snap-scroll', isHome);

        if (!event.urlAfterRedirects.includes('#')) {
          // Wait a frame so the browser has actually recomputed styles (dropped
          // scroll-snap-type) after the class change above before we scroll —
          // doing both in the same synchronous tick isn't enough; the snap
          // target gets resolved against stale style data otherwise.
          this.document.defaultView?.requestAnimationFrame(() => {
            this.document.defaultView?.scrollTo({ top: 0, left: 0, behavior: 'instant' });
          });
        }
      });
  }
}
