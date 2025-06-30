package com.expensestracker;
	import java.sql.*;
	import java.util.Scanner;

	public class ExpenseTrackerApp {
	    static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
	    static final String USER = "root"; // replace if needed
	    static final String PASS = "ganga123"; // replace with your MySQL password

	    static Scanner sc = new Scanner(System.in);
	    static int currentUserId = -1;

	    public static void main(String[] args) throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection conn = DriverManager.getConnection(URL, USER, PASS);

	        while (true) {
	            System.out.println("\n=== Welcome to Expense Tracker ===");
	            System.out.println("1. Register");
	            System.out.println("2. Login");
	            System.out.println("3. Exit");
	            System.out.print("Choose option: ");
	            int option = sc.nextInt();
	            sc.nextLine();

	            if (option == 1) {
	                register(conn);
	            } else if (option == 2) {
	                if (login(conn)) {
	                    runExpenseTracker(conn);
	                } else {
	                    System.out.println("❌ Invalid credentials.");
	                }
	            } else {
	                System.out.println("Goodbye!");
	                conn.close();
	                System.exit(0);
	            }
	        }
	    }

	    static void register(Connection conn) throws SQLException {
	        System.out.println("\n--- Register ---");
	        System.out.print("Username: ");
	        String username = sc.nextLine();
	        System.out.print("Password: ");
	        String password = sc.nextLine();

	        String sql = "INSERT INTO users1 (username, password) VALUES (?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, password);

	        try {
	            ps.executeUpdate();
	            System.out.println("✅ Registered successfully!");
	        } catch (SQLIntegrityConstraintViolationException e) {
	            System.out.println("⚠ Username already exists!");
	        }
	    }

	    static boolean login(Connection conn) throws SQLException {
	        System.out.println("\n--- Login ---");
	        System.out.print("Username: ");
	        String username = sc.nextLine();
	        System.out.print("Password: ");
	        String password = sc.nextLine();

	        String sql = "SELECT * FROM users1 WHERE username = ? AND password = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            currentUserId = rs.getInt("id");
	            System.out.println("✅ Login successful!");
	            return true;
	        }
	        return false;
	    }

	    static void runExpenseTracker(Connection conn) throws SQLException {
	        while (true) {
	            System.out.println("\n=== Expense Tracker Menu ===");
	            System.out.println("1. Add Entry");
	            System.out.println("2. View Entries");
	            System.out.println("3. Summary");
	            System.out.println("4. Delete Entry");
	            System.out.println("5. Logout");
	            System.out.print("Choose: ");
	            int ch = sc.nextInt();
	            sc.nextLine();

	            switch (ch) {
	                case 1: addEntry(conn); break;
	                case 2: viewEntries(conn); break;
	                case 3: viewSummary(conn); break;
	                case 4: deleteEntry(conn); break;
	                case 5: return;
	                default: System.out.println("Invalid option.");
	            }
	        }
	    }

	    static void addEntry(Connection conn) throws SQLException {
	        System.out.print("Type (Income/Expense): ");
	        String type = sc.nextLine();
	        System.out.print("Category (e.g. Food, Rent): ");
	        String category = sc.nextLine();
	        System.out.print("Amount: ");
	        double amount = sc.nextDouble();
	        sc.nextLine();
	        System.out.print("Date (YYYY-MM-DD): ");
	        String date = sc.nextLine();
	        System.out.print("Note: ");
	        String note = sc.nextLine();

	        String sql = "INSERT INTO expenses1 (user_id, type, category, amount, date, note) VALUES (?, ?, ?, ?, ?, ?)";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, currentUserId);
	        ps.setString(2, type);
	        ps.setString(3, category);
	        ps.setDouble(4, amount);
	        ps.setDate(5, Date.valueOf(date));
	        ps.setString(6, note);

	        ps.executeUpdate();
	        System.out.println("✅ Entry added.");
	    }

	    static void viewEntries(Connection conn) throws SQLException {
	        String sql = "SELECT * FROM expenses1 WHERE user_id = ? ORDER BY date DESC";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, currentUserId);

	        ResultSet rs = ps.executeQuery();
	        System.out.println("\n--- Your Expenses ---");
	        while (rs.next()) {
	            System.out.printf("ID: %d | %s | ₹%.2f | %s | %s | %s\n",
	                rs.getInt("id"),
	                rs.getString("type"),
	                rs.getDouble("amount"),
	                rs.getString("category"),
	                rs.getDate("date"),
	                rs.getString("note"));
	        }
	    }

	    static void viewSummary(Connection conn) throws SQLException {
	        String sql = "SELECT type, SUM(amount) AS total FROM expenses1 WHERE user_id = ? GROUP BY type";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, currentUserId);
	        ResultSet rs = ps.executeQuery();

	        double income = 0, expense = 0;
	        while (rs.next()) {
	            if (rs.getString("type").equalsIgnoreCase("Income"))
	                income = rs.getDouble("total");
	            else
	                expense = rs.getDouble("total");
	        }

	        System.out.println("\n--- Summary ---");
	        System.out.printf("Total Income: ₹%.2f\n", income);
	        System.out.printf("Total Expense: ₹%.2f\n", expense);
	        System.out.printf("Net Savings: ₹%.2f\n", (income - expense));
	    }

	    static void deleteEntry(Connection conn) throws SQLException {
	        System.out.print("Enter ID to delete: ");
	        int id = sc.nextInt();
	        sc.nextLine();

	        String sql = "DELETE FROM expenses1 WHERE id = ? AND user_id = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ps.setInt(2, currentUserId);

	        int rows = ps.executeUpdate();
	        if (rows > 0)
	            System.out.println("✅ Entry deleted.");
	        else
	            System.out.println("❌ Entry not found.");
	    }
	}
