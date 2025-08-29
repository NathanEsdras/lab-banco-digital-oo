public void setNome(String nome) {
    if(nome == null || nome.isEmpty()) {
        System.out.println("Nome inválido!");
        return;
    }
    this.nome = nome;
}
 
