Perfect — let’s do a **step‑by‑step dry run with sample outputs** for each join type using the `Transactions`, `CreditCard`, and `Merchant` tables we defined earlier. This way your trainees can *see* how rows are included or excluded.

---

## 🏦 Tables Recap

**CreditCard**
| CardNumber | Holder   |
|------------|----------|
| 1111       | Vikas    |
| 1232       | Richard  |
| 9999       | Sneha    | ← has no transactions

**Merchant**
| MerchantID | MerchantName |
|------------|--------------|
| M1         | Amazon       |
| M2         | Flipkart     |
| M3         | Myntra       | ← has no transactions

**Transactions**
| TxID | CardNumber | MerchantID | Amount |
|------|------------|------------|--------|
| T1   | 1111       | M1         | 500    |
| T2   | 1232       | M2         | 1000   |
| T3   | 1111       | M2         | 200    |

---

## 🔹 INNER JOIN
Definition: Returns rows that have matching values in both tables.

Example: Show transactions with card holder and merchant name.
```sql
SELECT t.TxID, c.Holder, m.MerchantName, t.Amount
FROM Transactions t
INNER JOIN CreditCard c ON t.CardNumber = c.CardNumber
INNER JOIN Merchant m ON t.MerchantID = m.MerchantID;
```

**Output:**
| TxID | Holder  | MerchantName | Amount |
|------|---------|--------------|--------|
| T1   | Vikas   | Amazon       | 500    |
| T2   | Richard | Flipkart     | 1000   |
| T3   | Vikas   | Flipkart     | 200    |

👉 Only matching rows across all three tables.

---

## 🔹 LEFT JOIN
Definition: Returns all rows from the left table, 
and matching rows from the right table. If no match, NULLs are shown.

Example: Show all credit cards and their transactions (even if no transaction).
```sql
SELECT c.Holder, t.TxID, t.Amount
FROM CreditCard c
LEFT JOIN Transactions t ON c.CardNumber = t.CardNumber;
```

**Output:**
| Holder  | TxID | Amount |
|---------|------|--------|
| Vikas   | T1   | 500    |
| Vikas   | T3   | 200    |
| Richard | T2   | 1000   |
| Sneha   | NULL | NULL   |

👉 All cards appear; Sneha has no transactions → NULLs.

---

## 🔹 RIGHT JOIN
Definition: Returns all rows from the right table, and matching 
rows from the left table.

Example: Show all merchants and their transactions (even if no transaction).
```sql
SELECT m.MerchantName, t.TxID, t.Amount
FROM Transactions t
RIGHT JOIN Merchant m ON t.MerchantID = m.MerchantID;
```

**Output:**
| MerchantName | TxID | Amount |
|--------------|------|--------|
| Amazon       | T1   | 500    |
| Flipkart     | T2   | 1000   |
| Flipkart     | T3   | 200    |
| Myntra       | NULL | NULL   |

👉 All merchants appear; Myntra has no transactions → NULLs.

---

## 🔹 FULL OUTER JOIN (simulated with UNION of LEFT + RIGHT)
Definition: Returns all rows when there is a match in either left or right table.
(Not supported in MySQL directly, but can be simulated with 
UNION of LEFT and RIGHT joins.)

Example: Show all credit cards and merchants with transactions if they exist.
```sql
SELECT c.Holder, t.TxID, m.MerchantName, t.Amount
FROM CreditCard c
LEFT JOIN Transactions t ON c.CardNumber = t.CardNumber
LEFT JOIN Merchant m ON t.MerchantID = m.MerchantID
UNION
SELECT c.Holder, t.TxID, m.MerchantName, t.Amount
FROM CreditCard c
RIGHT JOIN Transactions t ON c.CardNumber = t.CardNumber
RIGHT JOIN Merchant m ON t.MerchantID = m.MerchantID;
```

**Output (combined):**
| Holder  | TxID | MerchantName | Amount |
|---------|------|--------------|--------|
| Vikas   | T1   | Amazon       | 500    |
| Richard | T2   | Flipkart     | 1000   |
| Vikas   | T3   | Flipkart     | 200    |
| Sneha   | NULL | NULL         | NULL   |
| NULL    | NULL | Myntra       | NULL   |

👉 Shows everything: all cards, all merchants, all transactions.

---

## 🎯 Teaching Tip
- **INNER JOIN** → “Only successful matches.”  
- **LEFT JOIN** → “All cards, even if no transaction.”  
- **RIGHT JOIN** → “All merchants, even if no transaction.”  
- **FULL OUTER JOIN** → “Everything, matched or not.”  

---

Would you like me to also prepare a **visual diagram (Venn‑style)** 
showing how each join overlaps the sets (Transactions, CreditCard, Merchant)? 
That’s often the quickest way for trainees to grasp the difference.