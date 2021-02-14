CREATE TABLE `orders` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `price` INTEGER NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `order_items` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    `product_id` BIGINT UNSIGNED NOT NULL,
    `order_id` BIGINT UNSIGNED NOT NULL,
    `price_per_product` INTEGER NOT NULL,
    `price` INTEGER NOT NULL,
    `quantity` INTEGER NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`)
);

INSERT INTO orders (id, price)
VALUES
(1, 100),
(2, 200);

INSERT INTO order_items (product_id, order_id, price, price_per_product, quantity)
VALUES
(2, 1, 160, 80, 2),
(1, 1, 60, 60, 1),
(5, 1, 2500, 250, 10),
(4, 2, 400, 100, 4),
(7, 2, 140, 70, 2);