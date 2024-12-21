package com.ism.Controllers;

import com.ism.data.entites.Client;


public interface IClientView extends IView<Client> {
    Client saisir();
}
