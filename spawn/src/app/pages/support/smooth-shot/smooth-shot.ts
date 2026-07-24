import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon } from '../../../components/icon/icon';

interface Faq {
  question: string;
  answer: string;
}

@Component({
  selector: 'app-smooth-shot-support',
  imports: [Icon, RouterLink],
  templateUrl: './smooth-shot.html',
})
export class SmoothShotSupport {
  readonly faqs: Faq[] = [
    {
      question: 'How do I clean my Smooth Shot?',
      answer: 'Wipe it down with a dry or slightly damp microfiber cloth. Avoid submerging it or using harsh solvents.',
    },
    {
      question: "It's not responding",
      answer: 'Try a different USB port or cable, and make sure nothing else is using the same port. Reconnecting usually resolves it.',
    },
    {
      question: 'Does it work with any setup?',
      answer: "Smooth Shot works with any system that supports standard USB input devices — no drivers or extra software required.",
    },
    {
      question: 'What if mine arrived damaged or isn’t working?',
      answer: "Reach out to support with your order details and we'll sort out a replacement or repair.",
    },
  ];
}
