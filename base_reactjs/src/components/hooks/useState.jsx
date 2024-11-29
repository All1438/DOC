import React, {useState} from 'react';
import {render} from 'react-dom' // permet a l'utilisation de render

function useIncrement(initial, step) {
    const [count, setCount] = useState(initial)
    const increment = () => {
        setCount(c => c + step)
    }
    return [count, increment]
} 
function CompteurA() { //Hook découpage
    const [count, increment] = useIncrement(0, 2)
    // increment = permet de faire le mise a jour ultérieurement
    return <React.Fragment>
        <button onClick={increment}>Incrementer {count}</button>
    </React.Fragment>
}

function CompteurB() {
    const [count, setCount] = useState(0) // hook ne fonctionne pas dans class, mais on peut les utilisés pour éviter les class
    // count = represente une variable d'etat qui est initialisé à 0, count est similaire a state et setCount est this.setState
    // setCount = permet de faire le mis a jour ultérieurement
    // ne peut pas être utiliser dans une condition ou dans une boucle qui pourra changer l'ordre des appels
    const handleClick = function(e) {
        e.preventDefault()
        setCount(count + 1) // le MAJ de count
    }
    return <button onClick={handleClick}>Incrementer {count}</button>
}

render(
    <div>
        
        <CompteurA />
        <CompteurB />
    </div>,
    document.getElementById("root")
)