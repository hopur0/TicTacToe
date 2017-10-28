# Design report
*Describes the initial design.*
We are implementing the game TicTacToe.
## Tic-tac-toe
The game is played between two players commonly, X and O. The players take turns marking the spaces in a 3x3 grid. The player that is first to get three of their marks in a horizontal, vertical or a diagonal row wins the game.
[Wikipedia](https://en.wikipedia.org/wiki/Tic-tac-toe)
## Our implementation
We implement the game in Java and the game will be playable in both on the web and in a terminal environment.
### Classes
#### UI class
The user interface class or UI class is a template class that manages how we get input from users and pass them on to the game. TUI or terminal user interface or GUI graphical user interface could for example be sub-UI classes.
#### Player class
The player class holds information about the player, e.x. name and marker.
#### Board class
The board class holds the state of the board (which players have marked which space) and knows when the game has been won.
#### Game class
The game class holds the game loop it has, a instance of a UI class to request data from the user, a instance of the Board class and two instances of the Player class.