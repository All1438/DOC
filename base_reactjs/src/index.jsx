import ReactDOM from 'react-dom'
import React from 'react'
import App from './App.jsx'
import './App.css'

ReactDOM.render( // ReactDOM.render() = permet de rendre un élément App dans la page HTML, en insérant avec ID 'root'
    <React.StrictMode>  {/* React.StrictMode = permet de verifier que le code dans l'applications suits les bonnes pratiques et les règles recommandés  */}
        <App />
    </React.StrictMode>,
    document.getElementById("root")
)