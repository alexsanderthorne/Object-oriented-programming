tabela = ("santos", "vasco", "nautico", "vitoria",
          "chapecoense", "havaí", "são paulo")

# for clubes in range(tabela):
#    print(clubes)


def libertadores(tabela):

    for target_list in range(len(tabela)):
        print(target_list + 1, tabela[target_list])


print(libertadores(tabela))
