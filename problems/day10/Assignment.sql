Since you’ll already be implementing the **Loan Management System** during your session, here’s another **simple but rich assignment** for your trainees:  

---

## 📘 Assignment: **Insurance Policy Tracker**

### Part A: Database Design
1. **Create the following tables**:
   - **Customer(CustomerID, CustomerName, DOB, ContactNo)**  
   - **PolicyType(PolicyType, PremiumRate, CoverageYears)**  
   - **Branch(BranchID, BranchName, Manager)**  
   - **Policy(PolicyID, CustomerID, PolicyType, PremiumAmount, BranchID)**  

2. **Insert sample data**:
   - Customers:  
     - C1: Ramesh, 1985‑05‑10, 9876543210  
     - C2: Kavya, 1990‑09‑15, 9123456789  
   - PolicyTypes:  
     - Health – 5% premium, 10 years coverage  
     - Life – 8% premium, 20 years coverage  
     - Vehicle – 6% premium, 5 years coverage  
   - Branches:  
     - B1: Bangalore – Manager: Anil  
     - B2: Mysore – Manager: Sneha  
   - Policies:  
     - P1: Ramesh, Health, 20000, Bangalore  
     - P2: Ramesh, Vehicle, 15000, Bangalore  
     - P3: Kavya, Life, 50000, Mysore  

---

### Part B: Queries

#### JOINS
- **Q1:** List all policies with customer name, branch name, and manager.  
```sql
SELECT p.PolicyID, c.CustomerName, p.PolicyType, p.PremiumAmount, b.BranchName, b.Manager
FROM Policy p
JOIN Customer c ON p.CustomerID = c.CustomerID
JOIN Branch b ON p.BranchID = b.BranchID;
```

- **Q2:** Show policies with premium rate applied.  
```sql
SELECT p.PolicyID, c.CustomerName, p.PolicyType, p.PremiumAmount,
       pt.PremiumRate,
       (p.PremiumAmount * pt.PremiumRate/100) AS AnnualPremium
FROM Policy p
JOIN Customer c ON p.CustomerID = c.CustomerID
JOIN PolicyType pt ON p.PolicyType = pt.PolicyType;
```

---

#### Aggregate Functions
- **Q3:** Find total premium amount per customer.  
```sql
SELECT c.CustomerName, SUM(p.PremiumAmount) AS TotalPremium
FROM Policy p
JOIN Customer c ON p.CustomerID = c.CustomerID
GROUP BY c.CustomerName;
```

- **Q4:** Find average premium per branch.  
```sql
SELECT b.BranchName, AVG(p.PremiumAmount) AS AvgPremium
FROM Policy p
JOIN Branch b ON p.BranchID = b.BranchID
GROUP BY b.BranchName;
```

- **Q5:** Count number of policies by type.  
```sql
SELECT p.PolicyType, COUNT(*) AS PolicyCount
FROM Policy p
GROUP BY p.PolicyType;
```

---

### Part C: Practice Tasks
1. Write a query to find the **maximum premium amount per branch**.  
2. Write a query to list customers who have **more than one policy**.  
3. Write a query to calculate the **total annual premium payable per branch**.  

---

## 🎯 Learning Outcomes
- Reinforce **Normalization concepts** (Customer, Policy, Branch, PolicyType).  
- Practice **JOINS** to combine normalized tables.  
- Apply **Aggregate Functions** for analysis.  
- Compare with the Loan assignment to see how different financial verticals share similar DBMS/RDBMS design patterns.  

---

👉 This gives you a second vertical (Insurance) to balance with Loan during your training.  

Would you like me to also prepare a **Tax Filing System assignment** (third vertical) so you have a complete trio — Loan, Insurance, Tax — for rotation in different sessions?