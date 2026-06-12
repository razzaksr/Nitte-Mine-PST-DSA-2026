Perfect — let’s normalize the **Loan Management System** step by step, and I’ll add **SQL queries** at each stage so your trainees can run them hands‑on in MySQL/Postgres.

---

## 🏦 Loan Use Case Normalization

### 🔹 UNF (Unnormalized Form)
Data stored with multiple values in one cell:

| LoanID | CustomerName | LoanType | Amounts | Branch | Manager |
|--------|--------------|----------|---------|--------|---------|
| L1 | Arun  | Personal, Business | 50000, 200000 | Salem   | Kumar |
| L2 | Meera | Education          | 100000        | Chennai | Priya |

👉 Problem: Multi‑valued attributes.

---

### 🔹 1NF (First Normal Form)
**Rule:** Atomic values only.

**Loan Table**
| LoanID | CustomerName | LoanType | Amount | Branch | Manager |
|--------|--------------|----------|--------|--------|---------|
| L1 | Arun  | Personal | 50000  | Salem   | Kumar |
| L1 | Arun  | Business | 200000 | Salem   | Kumar |
| L2 | Meera | Education| 100000 | Chennai | Priya |

**SQL:**
```sql
CREATE TABLE Loan1NF (
    LoanID VARCHAR(10),
    CustomerName VARCHAR(50),
    LoanType VARCHAR(20),
    Amount DECIMAL(10,2),
    Branch VARCHAR(50),
    Manager VARCHAR(50)
);

INSERT INTO Loan1NF VALUES
('L1','Arun','Personal',50000,'Salem','Kumar'),
('L1','Arun','Business',200000,'Salem','Kumar'),
('L2','Meera','Education',100000,'Chennai','Priya');
```

---

### 🔹 2NF (Second Normal Form)
**Rule:** Remove partial dependency.  
Split customer info into its own table.

**Customer**
| CustomerID | CustomerName |
|------------|--------------|
| C1 | Arun  |
| C2 | Meera |

**Loan**
| LoanID | CustomerID | LoanType | Amount | Branch |
|--------|------------|----------|--------|--------|
| L1 | C1 | Personal | 50000  | Salem   |
| L1 | C1 | Business | 200000 | Salem   |
| L2 | C2 | Education| 100000 | Chennai |

**SQL:**
```sql
CREATE TABLE Customer (
    CustomerID VARCHAR(10) PRIMARY KEY,
    CustomerName VARCHAR(50)
);

CREATE TABLE Loan2NF (
    LoanID VARCHAR(10),
    CustomerID VARCHAR(10),
    LoanType VARCHAR(20),
    Amount DECIMAL(10,2),
    Branch VARCHAR(50),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID)
);

INSERT INTO Customer VALUES ('C1','Arun'),('C2','Meera');

INSERT INTO Loan2NF VALUES
('L1','C1','Personal',50000,'Salem'),
('L1','C1','Business',200000,'Salem'),
('L2','C2','Education',100000,'Chennai');
```

---

### 🔹 3NF (Third Normal Form)
**Rule:** Remove transitive dependency.  
Branch determines Manager, so separate Branch table.

**Branch**
| BranchID | BranchName | Manager |
|----------|------------|---------|
| B1 | Salem   | Kumar |
| B2 | Chennai | Priya |

**Loan**
| LoanID | CustomerID | LoanType | Amount | BranchID |
|--------|------------|----------|--------|----------|
| L1 | C1 | Personal | 50000  | B1 |
| L1 | C1 | Business | 200000 | B1 |
| L2 | C2 | Education| 100000 | B2 |

**SQL:**
```sql
CREATE TABLE Branch (
    BranchID VARCHAR(10) PRIMARY KEY,
    BranchName VARCHAR(50),
    Manager VARCHAR(50)
);

CREATE TABLE Loan3NF (
    LoanID VARCHAR(10),
    CustomerID VARCHAR(10),
    LoanType VARCHAR(20),
    Amount DECIMAL(10,2),
    BranchID VARCHAR(10),
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID),
    FOREIGN KEY (BranchID) REFERENCES Branch(BranchID)
);

INSERT INTO Branch VALUES ('B1','Salem','Kumar'),('B2','Chennai','Priya');

INSERT INTO Loan3NF VALUES
('L1','C1','Personal',50000,'B1'),
('L1','C1','Business',200000,'B1'),
('L2','C2','Education',100000,'B2');
```

---

### 🔹 BCNF (Boyce‑Codd Normal Form)
**Rule:** Every determinant must be a candidate key.  
LoanType determines InterestRate → separate LoanType table.

**LoanType**
| LoanType | InterestRate |
|----------|--------------|
| Personal | 12% |
| Business | 10% |
| Education| 8%  |

**Loan**
| LoanID | CustomerID | LoanType | Amount | BranchID |
|--------|------------|----------|--------|----------|

**SQL:**
```sql
CREATE TABLE LoanType (
    LoanType VARCHAR(20) PRIMARY KEY,
    InterestRate DECIMAL(5,2)
);

INSERT INTO LoanType VALUES
('Personal',12.00),
('Business',10.00),
('Education',8.00);
```

---

## 🎯 Teaching Flow
1. Show **UNF** with messy data.  
2. Apply **1NF** → atomic values.  
3. Apply **2NF** → separate customer.  
4. Apply **3NF** → separate branch manager.  
5. Apply **BCNF** → separate loan type interest.  
6. Run queries step by step in MySQL/Postgres to see the transformation.

---

👉 This way, trainees see **how normalization cleans the Loan System** and ensures data integrity.  

Would you like me to also prepare **sample JOIN queries** (like “list all loans with customer name, branch manager, and interest rate”) so they can practice combining these normalized tables?