using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
public class GridSpace : MonoBehaviour
{
    public Button button;
    public string text;
    public Image playerIcon;
    public GameObject imageOfGridSpace;
    private GameController gameController;
    
    public void SetGameControllerReference(GameController controller)
    {
        gameController = controller;

    }
    public void SetSpace()
    {
        text = gameController.GetPlayerSide();
        imageOfGridSpace.SetActive(true);
        playerIcon.sprite = gameController.GetPlayerSideImage();
        button.interactable = false;
        gameController.EndTurn();
      
    }
    public void ResetGridSpace()
    {
        text = "";
        playerIcon.sprite = null;
        imageOfGridSpace.SetActive(false);
    }
}