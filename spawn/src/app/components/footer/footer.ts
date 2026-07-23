import { Component } from '@angular/core';
import { Icon } from '../icon/icon';

@Component({
  selector: 'app-footer',
  imports: [Icon],
  templateUrl: './footer.html',
})
export class Footer {
  readonly year = new Date().getFullYear();

  readonly socials = ['Twitch', 'YouTube', 'Discord', 'TikTok', 'X', 'Reddit'];
  readonly shopLinks = ['All Products', 'Smooth Shot', 'Compass Joystick', 'Accessories'];
  readonly companyLinks = ['About Us', 'Our Mission', 'Reviews'];
  readonly supportLinks = ['FAQ', 'Contact Us', 'Shipping', 'Returns'];
  readonly legalLinks = ['Terms of Service', 'Privacy Policy', 'Refund Policy'];
}
