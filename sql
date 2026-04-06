
CREATE DATABASE cafe_management;
USE cafe_management;


CREATE TABLE items (
    item_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    stock_quantity INT NOT NULL,
    category VARCHAR(50)
);


CREATE TABLE transactions (
    transaction_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    total_amount DECIMAL(10,2) NOT NULL
);


CREATE TABLE transaction_details (
    detail_id INT PRIMARY KEY AUTO_INCREMENT,
    transaction_id INT,
    item_id INT,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (transaction_id) REFERENCES transactions(transaction_id),
    FOREIGN KEY (item_id) REFERENCES items(item_id)
);

-- Sample Data
INSERT INTO items (item_name, price, stock_quantity, category) VALUES
('Cake', 500.00, 10, 'Bakery'),
('Cupcake', 150.00, 20, 'Bakery'),
('Coffee', 200.00, 50, 'Beverage'),
('Tea', 100.00, 50, 'Beverage');
