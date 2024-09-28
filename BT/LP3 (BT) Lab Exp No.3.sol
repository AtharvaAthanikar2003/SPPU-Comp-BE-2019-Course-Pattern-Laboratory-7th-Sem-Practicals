// SPDX-License-Identifier: MIT
pragma solidity ^0.8.18;
contract Bank {
    mapping(address => uint) private balances;
    event Deposit(address indexed account, uint amount);
    event Withdrawal(address indexed account, uint amount);
    function deposit(uint amount) public {
        require(amount > 0, "Amount must be greater than zero.");
        balances[msg.sender] += amount;
        emit Deposit(msg.sender, amount);
    }
    function withdraw(uint amount) public {
        require(amount > 0, "Amount must be greater than zero.");
        require(balances[msg.sender] >= amount, "Insufficient balance.");
        balances[msg.sender] -= amount;
        emit Withdrawal(msg.sender, amount);
    }
    function getBalance() public view returns (uint) {
        return balances[msg.sender];
    }
}
