import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Icon, IconName } from '../../../components/icon/icon';

interface Screenshot {
  title: string;
  description: string;
  image: string;
}

interface TroubleshootingItem {
  question: string;
  answer: string;
}

interface Resource {
  label: string;
  url: string;
  icon: IconName;
}

interface Step {
  index: string;
  title: string;
  description: string;
}

const REPO_URL = 'https://github.com/juviscript/compass-meridian';

@Component({
  selector: 'app-compass-software',
  imports: [Icon, RouterLink],
  templateUrl: './compass-software.html',
})
export class CompassSoftware {
  readonly repoUrl = REPO_URL;
  readonly releasesUrl = `${REPO_URL}/releases`;

  readonly screenshots: Screenshot[] = [
    {
      title: 'Dashboard',
      description: 'See connection status, device info, active profile, and firmware version at a glance.',
      image: '/images/meridian/dashboard.png',
    },
    {
      title: 'Key Mapping',
      description: 'Remap Up, Down, Left, Right, and Click, and fine-tune directional and diagonal sensitivity.',
      image: '/images/meridian/mapping.png',
    },
    {
      title: 'Help & Troubleshooting',
      description: 'Built-in guidance, one-click access to your log file, and links to documentation and support.',
      image: '/images/meridian/help.png',
    },
  ];

  readonly gettingStarted: Step[] = [
    {
      index: '01',
      title: 'Plug It In',
      description: 'Connect your Compass via USB. Meridian detects it automatically.',
    },
    {
      index: '02',
      title: 'Pick a Profile',
      description: 'Start from a built-in preset (WASD, Arrow Keys, IJKL) or create your own.',
    },
    {
      index: '03',
      title: 'Remap & Tune',
      description: 'Assign keys to each direction and adjust sensitivity to feel.',
    },
    {
      index: '04',
      title: 'Apply',
      description: "Your mapping saves straight to the device's onboard memory.",
    },
  ];

  readonly troubleshooting: TroubleshootingItem[] = [
    {
      question: 'Compass not detected',
      answer:
        'Try unplugging and replugging the USB cable. Make sure no other app is using the serial port. Meridian will auto-reconnect within a few seconds.',
    },
    {
      question: 'Keys not registering in game',
      answer:
        'Make sure you clicked Apply after making changes. Try lowering the deadzone value (slide toward More Sensitive). Some games require the Compass to be plugged in before launching.',
    },
    {
      question: 'Diagonals not registering',
      answer:
        "Lower the Diagonal deadzone slider toward More Sensitive. The diagonal deadzone controls how far the secondary axis needs to move when you're already pushing in a direction.",
    },
    {
      question: 'Mapping resets after unplugging',
      answer:
        "Make sure you click Apply before unplugging. Your mapping is saved to the device's flash memory and should persist across power cycles.",
    },
  ];

  readonly resources: Resource[] = [
    { label: 'Latest Releases', url: this.releasesUrl, icon: 'download' },
    { label: 'Report an Issue', url: `${REPO_URL}/issues`, icon: 'alert-triangle' },
    { label: 'View Source on GitHub', url: REPO_URL, icon: 'github' },
  ];
}
