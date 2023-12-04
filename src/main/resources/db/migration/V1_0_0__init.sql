
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Create categories table
CREATE TABLE categories (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Create products table
CREATE TABLE products (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    price DOUBLE NOT NULL,
    seller_id BIGINT,
    category_id BIGINT,
    FOREIGN KEY (seller_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

-- Create ratings table
CREATE TABLE ratings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    stars INT NOT NULL,
    comment VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

-- Create reviews table
CREATE TABLE reviews (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    reviewer_id BIGINT,
    reviewed_user_id BIGINT,
    text TEXT,
    FOREIGN KEY (reviewer_id) REFERENCES users (id),
    FOREIGN KEY (reviewed_user_id) REFERENCES users (id)
);

-- Create transactions table
CREATE TABLE transactions (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    buyer_id BIGINT,
    seller_id BIGINT,
    date DATE NOT NULL,
    totalAmount DOUBLE NOT NULL,
    FOREIGN KEY (buyer_id) REFERENCES users (id),
    FOREIGN KEY (seller_id) REFERENCES users (id)
);

-- Create transaction_items table
CREATE TABLE transaction_items (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    transaction_id BIGINT,
    FOREIGN KEY (transaction_id) REFERENCES transactions (id)
);

-- Create user_ratings table
CREATE TABLE user_ratings (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    averageRating DOUBLE NOT NULL,
    totalRatings INT NOT NULL,
    positiveRatings INT NOT NULL,
    negativeRatings INT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id)
);
