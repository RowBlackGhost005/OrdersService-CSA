CREATE TABLE IF NOT EXISTS Orders (
    id INT AUTO_INCREMENT,
    user_id INT NOT NULL,
    order_date TIMESTAMP DEFAULT NOW(),
    status VARCHAR(16) CHECK (status IN ('Ordered' , "Processing" , "Shipped" , "Delivered" , "Cancelled")) DEFAULT 'Ordered',
    total DECIMAL(8,2) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS Order_details (
    id INT AUTO_INCREMENT,
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    quantity INT NOT NULL DEFAULT 1,
    unit_price DECIMAL(8,2) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_ProductOrder FOREIGN KEY (order_id) REFERENCES Orders(id)
);