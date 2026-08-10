import { writeFile } from 'node:fs/promises';
import { fileURLToPath } from 'node:url';
import path from 'node:path';

const SMOOTH_SHOT_LISTING_ID = 4318568597;

const apiKey = process.env.ETSY_API_KEY;
const sharedSecret = process.env.ETSY_SHARED_SECRET;

if (!apiKey || !sharedSecret) {
  console.error('Missing ETSY_API_KEY or ETSY_SHARED_SECRET in the environment.');
  process.exit(1);
}

const authHeader = { 'x-api-key': `${apiKey}:${sharedSecret}` };
const API_BASE = 'https://openapi.etsy.com/v3/application';

async function fetchJson(url) {
  const response = await fetch(url, { headers: authHeader });
  if (!response.ok) {
    const body = await response.text();
    throw new Error(`${url} -> ${response.status}: ${body}`);
  }
  return response.json();
}

async function fetchSmoothShot() {
  const [listing, images] = await Promise.all([
    fetchJson(`${API_BASE}/listings/${SMOOTH_SHOT_LISTING_ID}`),
    fetchJson(`${API_BASE}/listings/${SMOOTH_SHOT_LISTING_ID}/images`),
  ]);

  return {
    listingId: listing.listing_id,
    title: listing.title,
    description: listing.description,
    price: `$${(listing.price.amount / listing.price.divisor).toFixed(2)}`,
    url: listing.url,
    images: images.results
      .sort((a, b) => a.rank - b.rank)
      .map((image) => image.url_fullxfull),
  };
}

async function main() {
  console.log('Fetching Smooth Shot listing from Etsy...');
  const smoothShot = await fetchSmoothShot();
  console.log(`Fetched "${smoothShot.title}" (${smoothShot.images.length} images).`);

  const data = {
    smoothShot,
    fetchedAt: new Date().toISOString(),
  };

  const outPath = path.join(
    path.dirname(fileURLToPath(import.meta.url)),
    '../src/app/data/etsy-listings.json',
  );
  await writeFile(outPath, `${JSON.stringify(data, null, 2)}\n`);
  console.log(`Wrote ${outPath}`);
}

main().catch((error) => {
  console.error('Failed to sync Etsy listings:', error.message);
  process.exit(1);
});
