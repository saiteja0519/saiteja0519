import java.sql.*;

public class AccountDAO {

    public void createAccount(String name, double balance) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO accounts (name, balance) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setDouble(2, balance);
            ps.executeUpdate();
            System.out.println("Account created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deposit(int accNo, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "UPDATE accounts SET balance = balance + ? WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, accNo);
            ps.executeUpdate();
            System.out.println("Deposit successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void withdraw(int accNo, double amount) {
        try (Connection con = DBConnection.getConnection()) {
            String check = "SELECT balance FROM accounts WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(check);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("balance");
                if (balance >= amount) {
                    String sql = "UPDATE accounts SET balance = balance - ? WHERE account_no = ?";
                    PreparedStatement ps2 = con.prepareStatement(sql);
                    ps2.setDouble(1, amount);
                    ps2.setInt(2, accNo);
                    ps2.executeUpdate();
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkBalance(int accNo) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE account_no = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, accNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("\nAccount No: " + rs.getInt("account_no"));
                System.out.println("Name      : " + rs.getString("name"));
                System.out.println("Balance   : ₹" + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
