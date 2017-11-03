package se.nullable.kth.id1212.hangman.server.model

class Game(word: String) {
  private var _triesRemaining = 5
  private var _triedLetters = Set[Char]()

  def triesRemaining = _triesRemaining
  def triedLetters = _triedLetters

  def tryLetter(letter: Char): Unit = {
    if (!gameOver && !triedLetters.contains(letter) && isLetter(letter)) {
      _triedLetters += letter
      if (!word.contains(letter)) {
        _triesRemaining -= 1
      }
    }
  }

  def isLetter(chr: Char) = chr >= 'a' && chr <= 'z'
  def clue: String = word.map {
    case chr if isLetter(chr) && !triedLetters.contains(chr) => '_'
    case chr => chr
  }

  def isSolved = clue == word
  def gameOver = triesRemaining == 0 || isSolved
}
