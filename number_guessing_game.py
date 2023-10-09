import random

def generate_random_number(level):
    if level == "easy":
        return random.randint(1, 10)
    elif level == "medium":
        return random.randint(1, 50)
    elif level == "hard":
        return random.randint(1, 100)
    else:
        print("Invalid level. Please enter a valid level.")
        return None

def play_game():
    print("Welcome to the Number Guessing Game!")
    print("I'm thinking of a number between 1 and 100.")
    level = input("Choose a difficulty. Type 'easy', 'medium', or 'hard': ").lower()
    random_number = generate_random_number(level)
    attempts = 0
    score = 100
    
    while True:
        guess = int(input("Make a guess: "))
        attempts += 1
        
        if guess < random_number:
            print("Too low! Try again.")
        elif guess > random_number:
            print("Too high! Try again.")
        else:
            print(f"Congratulations! You guessed the number {random_number} in {attempts} attempts.")
            print(f"Your final score is: {score}")
            break
        
        if level == "easy":
            score -= 10
        elif level == "medium":
            score -= 5
        elif level == "hard":
            score -= 2
        
        if score <= 0:
            print("Game over! You ran out of attempts.")
            print(f"The correct number was: {random_number}")
            break

play_game()
