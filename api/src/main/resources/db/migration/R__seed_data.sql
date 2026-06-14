-- Products
INSERT INTO products (name, description, description_html, price, is_component_assembled, is_active)
VALUES
    ('Compass', 'RP2040-based Hall Effect joystick USB HID device', '<p>RP2040-based Hall Effect joystick USB HID device</p>', 35.00, TRUE, TRUE),
    ('SmoothShot', 'Ergonomic wrist rest', '<p>Ergonomic wrist rest</p>', 20.00, FALSE, TRUE);

-- Compass
INSERT INTO product_variants (product_id, variant_name, color, size, price, stock_quantity)
SELECT id, 'Standard - Black', 'Black', NULL, 35.00, 10
FROM products WHERE name = 'Compass';

-- SmoothShot variants: 7 designs x 2 hand orientations = 14 variants
INSERT INTO product_variants (product_id, variant_name, color, size, price, stock_quantity)
SELECT id, design || ' - ' || hand || ' Handed', design, hand, 20.00, 10
FROM products,
     (VALUES ('Design 1'), ('Design 2'), ('Design 3'), ('Design 4'), ('Design 5'), ('Design 6'), ('Design 7')) AS designs(design),
     (VALUES ('Right'), ('Left')) AS hands(hand)
WHERE name = 'SmoothShot';