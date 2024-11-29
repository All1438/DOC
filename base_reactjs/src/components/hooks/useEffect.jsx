import React, {useState, useEffect} from "react";
import {render} from "react-dom"

function Compteur() {
    const [state, setState] = useState(0)
    useEffect(() => { // similaire a componentDidMount (permet de déterminer quand un composant a été monté)
        // useEffect() = récement utilisé pour les intervals et les timer
        const timer = window.setInterval(() =>{
            setState()
        }, 1000) // second paramètre = permet a useEffect se déclanche a chaque fois que le second variable change, si il est vide ce sera a chaque mis a jours
        return function() { // la suppression du composant
          clearInterval(timer)
        }
    }, []) // tableau vide si ...
    return <React.Fragment>
            Valeur {state} 
            <button onClick={setState}>Incrementer</button>
        </React.Fragment>
}
render(
    <div>
        <Compteur/>
    </div>,
    document.getElementById("root")
)