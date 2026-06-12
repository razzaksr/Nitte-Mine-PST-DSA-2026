Got it — let’s implement **aggregate functions** on the **CreditCard, Transactions, and Merchant** tables we used earlier. This will give your trainees a direct feel for how aggregates summarize transactional data.

---

## 🔹 Tables Recap

**CreditCard**
| CardNumber | Holder   |
|------------|----------|
| 1111       | Vikas    |
| 1232       | Richard  |
| 9999       | Sneha    | ← no transactions

**Merchant**
| MerchantID | MerchantName |
|------------|--------------|
| M1         | Amazon       |
| M2         | Flipkart     |
| M3         | Myntra       | ← no transactions

**Transactions**
| TxID | CardNumber | MerchantID | Amount |
|------|------------|------------|--------|
| T1   | 1111       | M1         | 500    |
| T2   | 1232       | M2         | 1000   |
| T3   | 1111       | M2         | 200    |

---

## 🔹 Aggregate Function Queries

### 1. **Total Spend per Card Holder**
```sql
SELECT c.Holder, SUM(t.Amount) AS TotalSpend
FROM Transactions t
JOIN CreditCard c ON t.CardNumber = c.CardNumber
GROUP BY c.Holder;
```
**Expected Output:**
| Holder  | TotalSpend |
|---------|------------|
| Vikas   | 700        |
| Richard | 1000       |

---

### 2. **Average Transaction Amount per Merchant**
```sql
SELECT m.MerchantName, AVG(t.Amount) AS AvgTransaction
FROM Transactions t
JOIN Merchant m ON t.MerchantID = m.MerchantID
GROUP BY m.MerchantName;
```
**Expected Output:**
| MerchantName | AvgTransaction |
|--------------|----------------|
| Amazon       | 500            |
| Flipkart     | 600            |

---

### 3. **Count Transactions per Merchant**
```sql
SELECT m.MerchantName, COUNT(t.TxID) AS TxCount
FROM Merchant m
LEFT JOIN Transactions t ON m.MerchantID = t.MerchantID
GROUP BY m.MerchantName;
```
**Expected Output:**
| MerchantName | TxCount |
|--------------|---------|
| Amazon       | 1       |
| Flipkart     | 2       |
| Myntra       | 0       |

---

### 4. **Maximum Transaction Amount per Card Holder**
```sql
SELECT c.Holder, MAX(t.Amount) AS MaxTransaction
FROM Transactions t
JOIN CreditCard c ON t.CardNumber = c.CardNumber
GROUP BY c.Holder;
```
**Expected Output:**
| Holder  | MaxTransaction |
|---------|----------------|
| Vikas   | 500            |
| Richard | 1000           |

---

### 5. **Total Spend per Merchant**
```sql
SELECT m.MerchantName, SUM(t.Amount) AS TotalRevenue
FROM Transactions t
JOIN Merchant m ON t.MerchantID = m.MerchantID
GROUP BY m.MerchantName;
```
**Expected Output:**
| MerchantName | TotalRevenue |
|--------------|--------------|
| Amazon       | 500          |
| Flipkart     | 1200         |

---

## 🎯 Teaching Flow
- Start with **COUNT()** (transactions per merchant).  
- Move to **SUM()** (total spend).  
- Show **AVG()** (average spend).  
- Add **MAX()** (largest transaction).  
- End with a **business insight query** (merchant revenue).  

---

👉 This way, your trainees see how aggregate functions turn 
raw transaction data into **business intelligence**.  

Would you like me to also prepare a **mini case study** 
(e.g., “Find the top‑spending customer and top‑earning merchant”) 
so they can practice combining aggregates with `ORDER BY` and `LIMIT`?