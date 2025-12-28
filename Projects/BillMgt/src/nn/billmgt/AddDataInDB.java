package nn.billmgt;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// create table items
// (
//     id int primary key,
//     name Varchar(30),
//     discount float,
//     stock int
// )

// create table bill
// (
//     billId int primary key,
//     custName varchar(40),
//     custPhone varchar(10),
//     billDate date
// )

// create table custBuyed
// (
//     billId int,
//     itembuyed varchar(40)
// )

// create table custItemQuantity
// (
//     billId int,

// )


public class AddDataInDB {
    public static void main(String[] args) throws SQLException {
        try
        (
            Connection con = MySQL_Connector.getConnection("bill");
        )
        {
            Statement stmt = con.createStatement();
            
            stmt.execute("create table items\r\n" + //
                        "(\r\n" + //
                        "    id int primary key,\r\n" + //
                        "    name Varchar(30),\r\n" + //
                        "    price float,\r\n" + //
                        "    discount float,\r\n" + //
                        "    stock int\r\n" + //
                        ")");
            stmt.close();

            stmt = con.createStatement();
            stmt.execute("create table bill\r\n" + //
                        "(\r\n" + //
                        "    billId int primary key,\r\n" + //
                        "    custName varchar(40),\r\n" + //
                        "    custPhone varchar(10),\r\n" + //
                        "    billDate date\r\n" + //
                        ")");
            stmt.close();

            stmt = con.createStatement();
            stmt.execute("create table custBuyed\r\n" + //
                        "(\r\n" + //
                        "    billId int,\r\n" + //
                        "    itembuyed varchar(40)\r\n" + //
                        ")");
            stmt.close();
        }
    }
}
