# Solicita ao usuário os dados dos carros e consumos
modelos = []
consumos = []

for i in range(3):
    modelo = input(f"Carro {i + 1}: ")
    while True:
        try:
            consumo = float(input(f"Km por litro do {modelo}: "))
            break
        except ValueError:
            print("Por favor, insira um número válido para o consumo.")
    modelos.append(modelo)
    consumos.append(consumo)

# Define a distância e o preço da gasolina
distancia = 500  # distância em km
preco_gasolina = 4.90  # preço por litro de gasolina

# Calcula e exibe os resultados
print("\n================================================================")
for i in range(3):
    litros_necessarios = distancia / consumos[i]
    custo = litros_necessarios * preco_gasolina
    print(f"O {modelos[i]} faz {consumos[i]} km por litro, e utilizou {litros_necessarios:.1f} litros para percorrer {distancia} km e gastou em torno de R$ {custo:.2f}")
