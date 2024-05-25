#Display the board
#Let user input a x or o in box 
#Check if the 0-8 is okay for input
#Update the array after user input 
#Have turns for each user 
#Let the user know if they won 
#Let them play again with a while loop

'''
array =[
    [0],[1],[2],
    [3],[4],[5],
    [6],[7],[8]]
'''
array =[
    [0],[0],[0],
    [0],[0],[0],
    [0],[0],[0]]

#Instructions
def instructions():
    print("""Welcome to Tic-Tac-Toe!
First one to get 3 in a row wins!
          """)

#Diplays
def board(display):
    for i in range(len(array)):
        print(array[i], end = "")
        if (i == 2 or i == 5):
            print("")

#Checks if there are any available spaces
def condition():
    for i in range(0, len(array)):
        for j in range(0, len(array[0])):
            if array[i][j] == 0:
                return True
    return False

def outcome() -> int:
    player1Win = 1
    player2Win = 2
    draw = 0
    for i in range(0, len(array)):
        for j in range(0, len(array[0])):
            if((#Checks rows 
            (array[0][j] == 'O') and (array[1][j] == 'O') and (array[2][j] == 'O')) or ((array[3][j] == 'O') and (array[4][j] == 'O') and 
                                                                                    (array[5][j] == 'O'))
            or ((array[6][j] == 'O') and (array[7][j] == 'O') and (array[8][j] == 'O')) 
            #Checks Diagonals 
            or ((array[0][j] == 'O') and (array[4][j] == 'O') and (array[8][j] == 'O')) or ((array[2][j] == 'O') and (array[4][j] == 'O') and 
                                                                                        (array[6][j] == 'O'))
            #Checks columns 
            or ((array[0][j] == 'O') and (array[3][j] == 'O') and (array[6][j] == 'O')) or ((array[1][j] == 'O') and (array[4][j] == 'O') and 
                                                                                        (array[7][j] == 'O'))
            or ((array[2][j] == 'O') and (array[5][j] == 'O') and (array[8][j] == 'O'))):
                #return 1 if player 1 wins
                return player1Win 
            
            elif ((#Checks rows 
            (array[0][j] == 'X') and (array[1][j] == 'X') and (array[2][j] == 'X')) or ((array[3][j] == 'X') and (array[4][j] == 'X') and 
                                                                                    (array[5][j] == 'X'))
            or ((array[6][j] == 'X') and (array[7][j] == 'X') and (array[8][j] == 'X')) 
            #Checks Diagonals 
            or ((array[0][j] == 'X') and (array[4][j] == 'X') and (array[8][j] == 'X')) or ((array[2][j] == 'X') and (array[4][j] == 'X') and 
                                                                                        (array[6][j] == 'X'))
            #Checks columns 
            or ((array[0][j] == 'X') and (array[3][j] == 'X') and (array[6][j] == 'X')) or ((array[1][j] == 'X') and (array[4][j] == 'X') and 
                                                                                        (array[7][j] == 'X'))
            or ((array[2][j] == 'X') and (array[5][j] == 'X') and (array[8][j] == 'X'))): 
                #return 2 if player 2 wins
                return player2Win

            else:
                #return 0 if draw
                return draw

#Checks if the user input is valid
def check(number) -> bool:
    for i in range(0, len(array)):
        for j in range(0, len(array[0])):
            if array[number][j] == 0:
                return True
        return False

def userInput() -> int:
    spot = int(input("Choose a spot (0 - 8): "))
    return spot

#Updates the array with an 'x' or 'o'
def updateArray(num, symbol):
    for i in range(0, len(array)):
        for j in range(0, len(array[0])):
            if array[num][j] == 0:
                array[num][j] = symbol
 

def gameplay():
    instructions()
    board(array)
    print()
    while (condition() == True):
        while(True):
            print()
            print("Player 1: ")
            placement = int(userInput())
            valid = check(placement)
            if valid == True:
                updateArray(placement, 'O')
            else:
                print("Space unavailable. Try Again!")
                continue
            break
        #Updates Array
        print()
        board(array)
        condition()
        print()
        #Checks if player 1 won
        if (outcome()) == 1:
            print()
            print("Player 1 Wins!")
            break 

        if condition() == True:
            while(True):
                print()
                print("Player 2: ")
                placement = int(userInput())
                valid = check(placement)
                if valid == True:
                    updateArray(placement, 'X')
                else:
                    print("Space unavailable. Try Again!")
                    continue
                break
            #Updates Array
            print()
            board(array)
            condition()
            print()
            #Checks if player 2 won
            if (outcome()) == 2:
                print()
                print("Player 2 Wins!")
                break

    print()
    if (outcome()) == 0:
        print("It's a Draw!")
                

gameplay()

