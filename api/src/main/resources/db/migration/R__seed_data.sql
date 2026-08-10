-- ============================================================
-- Admin user (default password: Admin1234! — change after first login)
-- ============================================================
INSERT INTO users (first_name, last_name, email, password_hash, role)
VALUES ('Juvi', 'Panaguiton', 'juviscript@gmail.com', '$2a$12$mQmTYSiKYRTJYqb1yFbOQ.VCnxFT7HW8gOEKRpnqf5bsxfpnLuKF6', 'SUPER_ADMIN')
ON CONFLICT (email) DO NOTHING;

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

-- ============================================================
-- Vendors
-- ============================================================
INSERT INTO vendors (name, website, notes)
VALUES
    ('Amazon', 'https://www.amazon.com', NULL),
    ('In-House', NULL, 'Custom 3D printed or fabricated in-house');

-- ============================================================
-- Inventory Components
-- ============================================================
INSERT INTO inventory_components (component_name, quantity, vendor_id, vendor_product_url, unit)
VALUES
    -- Compass components
    ('RP2040 Zero Microcontroller Board',        0, (SELECT id FROM vendors WHERE name = 'Amazon'),   'https://www.amazon.com/dp/B0FND59TMH', 'pcs'),
    ('Hall-Effect Joystick',                     0, (SELECT id FROM vendors WHERE name = 'Amazon'),   'https://www.amazon.com/dp/B0FCY8S8FD', 'pcs'),
    ('3D Printed Enclosure (Compass)',            0, (SELECT id FROM vendors WHERE name = 'In-House'), NULL,                                   'pcs'),
    ('Micro JST-PH 2.0mm 2-Pin Connector Set',  0, (SELECT id FROM vendors WHERE name = 'Amazon'),   'https://www.amazon.com/dp/B0D7Q9HJLQ', 'pcs'),
    ('Micro JST-PH 2.0mm 3-Pin Connector Set',  0, (SELECT id FROM vendors WHERE name = 'Amazon'),   'https://www.amazon.com/dp/B0D9R28WDR', 'pcs'),
    ('30 AWG Wire 4" Black',                     0, NULL,                                              NULL,                                   'pcs'),
    ('30 AWG Wire 4" Red',                       0, NULL,                                              NULL,                                   'pcs'),
    ('Heat-Shrink Tubing 1mm Black 30mm',        0, (SELECT id FROM vendors WHERE name = 'Amazon'),   'https://www.amazon.com/dp/B0FJCVNVBP', 'pcs'),
    -- SmoothShot components
    ('3D Printed Wrist Rest',                    0, (SELECT id FROM vendors WHERE name = 'In-House'), NULL, 'pcs'),
    ('Graphic Sticker',                          0, (SELECT id FROM vendors WHERE name = 'In-House'), NULL, 'pcs'),
    ('Removable Wrist Band',                     0, NULL,                                              NULL, 'pcs'),
    ('Glass Lens',                               0, NULL,                                              NULL, 'pcs');

-- ============================================================
-- Bill of Materials (component_recipe)
-- ============================================================
INSERT INTO component_recipe (product_id, component_id, quantity)
SELECT p.id, c.id, r.qty
FROM products p
JOIN (VALUES
    ('Compass', 'RP2040 Zero Microcontroller Board',       1),
    ('Compass', 'Hall-Effect Joystick',                    1),
    ('Compass', '3D Printed Enclosure (Compass)',          1),
    ('Compass', 'Micro JST-PH 2.0mm 2-Pin Connector Set', 1),
    ('Compass', 'Micro JST-PH 2.0mm 3-Pin Connector Set', 1),
    ('Compass', '30 AWG Wire 4" Black',                    3),
    ('Compass', '30 AWG Wire 4" Red',                      2),
    ('Compass', 'Heat-Shrink Tubing 1mm Black 30mm',       4),
    ('SmoothShot', '3D Printed Wrist Rest',                1),
    ('SmoothShot', 'Graphic Sticker',                      1),
    ('SmoothShot', 'Removable Wrist Band',                 1),
    ('SmoothShot', 'Glass Lens',                           1)
) AS r(product_name, component_name, qty)
    ON p.name = r.product_name
JOIN inventory_components c ON c.component_name = r.component_name;