using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

[System.Serializable]
public class Player
{
    public Image panel;
    public Text text;
    public Button button;
    public Sprite playerImage;

}

[System.Serializable]
public class PlayerColor 
{
    public Color panelColor;
    public Color textColor;
}
public class GameController : MonoBehaviour
{
    public GridSpace[] gridSpaceList;
    public GameObject restartButton;
    public GameObject gameOverPanel;
    public GameObject startInfo;
    public Text gameOverText;
    public Player playerX;
    public Player playerO;
    public PlayerColor activePlayerColor;
    public PlayerColor inactivePlayerColor;

    private int moveCount;
    private string playerSide;
   

    private void Awake()
    {
        SetGameControllerReferenceOnButtons();
        gameOverPanel.SetActive(false);
        moveCount = 0;
        restartButton.SetActive(false);
        
    }
 
    public void SetStartingSide(string startingSide)
    {
        playerSide = startingSide;
        if (playerSide == "X"){
            SetPlayerColors(playerX, playerO);
        }
        else {
            SetPlayerColors(playerO, playerX);
        }
        StartGame();
    }
    void SetPlayerButtons (bool toggle)
    {
        playerX.button.interactable = toggle;
        playerO.button.interactable = toggle;
    }
    void StartGame()
    {
        SetBoardInteractable(true);
        SetPlayerButtons(false);
        startInfo.SetActive(false);
    }
    void SetGameControllerReferenceOnButtons()
    {
        for (int i = 0; i <gridSpaceList.Length; i++)
        {
            gridSpaceList[i].GetComponentInParent<GridSpace>().SetGameControllerReference(this);
        }
    }
    public string GetPlayerSide()
    {
        return playerSide;
    }
    public void EndTurn()
    {
        moveCount++;

        if (gridSpaceList[0].text == playerSide && gridSpaceList[1].text == playerSide && gridSpaceList[2].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[3].text == playerSide && gridSpaceList[4].text == playerSide && gridSpaceList[5].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[6].text == playerSide && gridSpaceList[7].text == playerSide && gridSpaceList[8].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[0].text == playerSide && gridSpaceList[3].text == playerSide && gridSpaceList[6].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[1].text == playerSide && gridSpaceList[4].text == playerSide && gridSpaceList[7].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[2].text == playerSide && gridSpaceList[5].text == playerSide && gridSpaceList[8].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[0].text == playerSide && gridSpaceList[4].text == playerSide && gridSpaceList[8].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (gridSpaceList[2].text == playerSide && gridSpaceList[4].text == playerSide && gridSpaceList[6].text == playerSide)
        {
            GameOver(playerSide);
        }
        else if (moveCount >= 9)
        {
            GameOver("draw");
        }
        else
        {
            ChangeSides();
        }
    }

    void ChangeSides()
    {
       playerSide = (playerSide == "X") ? "O" : "X";
       if(playerSide == "X") {
            SetPlayerColors(playerX, playerO);
           
        }
        else
        {
            SetPlayerColors(playerO, playerX);
        }
    }

    public Sprite GetPlayerSideImage()
    {
        if (playerSide == "X")
        {
            return playerX.playerImage;
        }
        else
        {
            return playerO.playerImage;
        }
    }
    void SetPlayerColors(Player newPlayer, Player oldPlayer)
    {
        newPlayer.panel.color = activePlayerColor.panelColor;
        newPlayer.text.color = activePlayerColor.textColor;
        oldPlayer.panel.color = inactivePlayerColor.panelColor;
        oldPlayer.text.color = inactivePlayerColor.textColor;
    }
    void SetPlayerColorsInactive()
    {
        playerX.panel.color = inactivePlayerColor.panelColor;
        playerX.text.color = inactivePlayerColor.textColor;
        playerO.panel.color = inactivePlayerColor.panelColor;
        playerO.text.color = inactivePlayerColor.textColor;
    }

    void SetPlayerColorsActive()
    {
        playerX.panel.color = activePlayerColor.panelColor;
        playerX.text.color = activePlayerColor.textColor;
        playerO.panel.color = activePlayerColor.panelColor;
        playerO.text.color = activePlayerColor.textColor;
    }
    void GameOver(string winningPlayer)
    {
        SetBoardInteractable(false);
        if (winningPlayer == "draw")
        {
            SetGameOverText("It's a Draw!");
            SetPlayerColorsInactive();
        }
        else
        {
            SetGameOverText(winningPlayer + " Wins!");
        }
        restartButton.SetActive(true);

        
    }
    void SetGameOverText(string text)
    {
        gameOverPanel.SetActive(true);
        gameOverText.text = text;
    }

    public void RestartGame()
    {
        moveCount = 0;
        gameOverPanel.SetActive(false);
        restartButton.SetActive(false);
        SetPlayerButtons(true);
        SetPlayerColorsActive();
        startInfo.SetActive(true);

        for (int i = 0; i < gridSpaceList.Length; i++)
        {
            gridSpaceList[i].ResetGridSpace();
        }
        
    }
    void SetBoardInteractable(bool toggle)
    {
        for (int i = 0; i < gridSpaceList.Length; i++)
        {
            gridSpaceList[i].GetComponentInParent<Button>().interactable = toggle;
        }
    }
}
