import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon } from '../../../components/icon/icon';
import { Carousel } from '../../../components/carousel/carousel';
import etsyListings from '../../../data/etsy-listings.json';

interface Faq {
  question: string;
  answer: string;
}

@Component({
  selector: 'app-product-smooth-shot',
  imports: [Icon, Carousel, RouterLink],
  templateUrl: './smooth-shot.html',
})
export class ProductSmoothShot {
  readonly listing = etsyListings.smoothShot;

  readonly faqs: Faq[] = [
    {
      question: "What's it made of?",
      answer: 'A 3D-printed PLA body with a glass glide surface and an adjustable nylon strap.',
    },
    {
      question: 'How long until it ships?',
      answer: "Every order is made to order and ships within 1–3 business days.",
    },
    {
      question: 'Will it fit my wrist?',
      answer: 'The nylon strap is adjustable, so it comfortably fits most wrist sizes.',
    },
    {
      question: 'Does it work with any mouse pad?',
      answer: "Yes — it's designed to glide smoothly on both cloth and hard mouse pads.",
    },
  ];
}
