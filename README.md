# Colour Spinner Guessing Game (Java)

A console-based Java game where you and the computer try to guess the colour of a virtual spinner.  
Across 10 rounds, you earn points for correct guesses, play random rock–paper–scissors bonus rounds, and compete to see who ends with the highest total score.

---

## Overview

This project implements a simple **text-based game** in Java:

- The spinner randomly lands on one of four colours:
  - **Red**
  - **Yellow**
  - **Green**
  - **Blue**
- In each round:
  - The **user** guesses a colour.
  - The **computer** randomly guesses a colour.
  - The **spinner** randomly generates the actual colour.
- Points are awarded based on how well the guesses match the spinner result.
- Two randomly chosen rounds trigger a **bonus rock–paper–scissors mini-game** for extra points.

The game runs entirely in the console using `Scanner` for user input and `Math.random()` for randomness.

---

## Gameplay

### 1. Game Setup

When you start the program:

1. The game prints the title: **COLOUR GAME**.
2. You are asked to enter:
   - Your **name**
   - Your **age** (must be between 0 and 122; otherwise you are prompted again)
3. A welcome message appears:
   - `Welcome <name> to the COLOUR GAME!`
4. The game prints the rules using the `rules()` method.

Internally:

- Total rounds: `10`
- Score tracking:
  - `userScore`, `compScore`
  - `userRoundsWon`, `compRoundsWon`
- Extra bonus points:
  - `userExtraPoints`, `compExtraPoints` (static variables)
- Two random rounds are chosen for bonus games:
  - `extraPointsRound1`
  - `extraPointsRound2`

---

### 2. Rounds & Scoring

For each of the 10 rounds:

1. The game prints:  
   `ROUND i:`
2. You are prompted to guess a colour:
   - `Enter your guess (Red, Yellow, Green, or Blue):`
3. Input is **validated**:
   - It must be one of: `red`, `yellow`, `green`, `blue` (case-insensitive).
4. The computer randomly chooses one of the four colours.
5. The spinner randomly selects the **actual colour**.

Then the game compares:

- **Tie on spinner** (both guessed correctly):
  - User guess == spinner colour
  - Computer guess == spinner colour
  - Both get **+1 point**:
    - `userScore++`
    - `compScore++`
  - A random “tie” message is printed via `tieResponses(...)`.

- **User wins the round**:
  - User guess == spinner colour
  - Computer guess != spinner colour
  - User gets **+2 points**:
    - `userScore += 2`
    - `userRoundsWon++`
  - A random “win” message is printed via `winResponses(...)`.

- **Computer wins the round**:
  - User guess != spinner colour
  - Computer guess == spinner colour
  - Computer gets **+2 points**:
    - `compScore += 2`
    - `compRoundsWon++`
  - A random “lose” message is printed via `loseResponses(...)`.

- **No one scores**:
  - Neither guess matches the spinner colour.
  - The game prints: `No one wins this round!`

---

### 3. Bonus Rounds (Rock–Paper–Scissors)

On **two randomly chosen rounds** (stored as `extraPointsRound1` and `extraPointsRound2`):

- After the normal colour guessing and scoring, the game calls:
  ```java
  extraPoints(extraPoints);
