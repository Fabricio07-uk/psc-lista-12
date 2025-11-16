import java.util.Locale;

public class TesteEncapsulamento {

    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);

        System.out.println("--- Teste de Conta Bancária ---");
        
        ContaBancaria conta = new ContaBancaria();

        System.out.println("\n1. Teste de Acesso Direto (Deve falhar se descomentado):");
        
        System.out.println("   // conta.saldo = 500.0;");
        System.out.println("   (A linha acima causa um ERRO DE COMPILAÇÃO, provando o encapsulamento.)");

        System.out.println("\n2. Configurando Conta (Setters):");
        conta.setTitular("Fabricio da Silva");
        conta.setNumeroConta("12345-6");

        System.out.println("\n3. Teste de Transações (Depósitos):");
        conta.depositar(500.00);
        conta.depositar(150.50);
        conta.depositar(-50.00);

        System.out.println("\n4. Teste de Transações (Saques):");
        conta.sacar(100.00);
        conta.sacar(600.00);
        conta.sacar(-30.00);

        System.out.println("\n5. Verificação Final (Getters):");
        System.out.println("Titular: " + conta.getTitular());
        System.out.println("Conta: " + conta.getNumeroConta());
        System.out.printf("Saldo Final: R$ %.2f\n", conta.getSaldo());
    }
}

class ContaBancaria {

    private String numeroConta;
    private String titular;
    private double saldo;

    public ContaBancaria() {
        this.saldo = 0.0;
    }

    public String getNumeroConta() {
        return this.numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        if (numeroConta != null && !numeroConta.trim().isEmpty()) {
            this.numeroConta = numeroConta;
        } else {
            System.out.println("[ERRO] O número da conta não pode ser nulo ou vazio.");
        }
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        if (titular != null && !titular.trim().isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("[ERRO] O nome do titular não pode ser nulo ou vazio.");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.printf("[+] Depósito de R$ %.2f realizado. Saldo atual: R$ %.2f\n", valor, this.saldo);
        } else {
            System.out.println("[ERRO] O valor do depósito deve ser positivo.");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("[ERRO] O valor do saque deve ser positivo.");
        } else if (valor > this.saldo) {
            System.out.printf("[ERRO] Saldo insuficiente. Saldo atual: R$ %.2f\n", this.saldo);
        } else {
            this.saldo -= valor;
            System.out.printf("[-] Saque de R$ %.2f realizado. Saldo atual: R$ %.2f\n", valor, this.saldo);
        }
    }
}