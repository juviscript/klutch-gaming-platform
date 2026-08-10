import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.html',
})
export class Footer {
  readonly year = new Date().getFullYear();

  readonly socials = ['Discord', 'TikTok'];
  readonly shopLinks = ['All Products', 'Smooth Shot', 'Compass Joystick', 'Accessories'];
  readonly legalLinks = ['Terms of Service', 'Privacy Policy', 'Refund Policy'];
}
