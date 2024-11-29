import React, {useState, useEffect} from 'react'

const app = () => {

    let [notes, setNotes] = useState([]) // empty

    useEffect(() => {
        getNotes()
    }, [])

    let getNotes = async () => { // async = c-a-d qu'elle effectue des operation qui prennent du temps sans bloqué le thread principale de l'application
        let response = await fetch('api/notes') // fetch("chemain vers l'autre app")
         // "http://127.0.0.1:8000" est ajouter au proxy dans package.json, il faut telecharger npm install react-router-dom pour qu'il fonctionne
        // await = permet d'attendre qu'une operation ascynchrone se termine avant de continué l'execution du code
        let data = await response.json()
        setNotes(data)
    }

  return (
    <div className="notes">
            <div className="notes-header">
                <h2 className="notes-title">&#9782; Notes</h2>
                <p className="notes-count">{notes.length}</p>
            </div>

            <div className="notes-list">
                {notes.map((note, index) => (
                    <h3 key={index}>{note.body}</h3> // {note.body} = maintenant on peut utilisé la paramètre de model en React
                    // key={index} == pk=id
                ))}
            </div>
            {/* <AddButton /> */}
        </div>
  )
}

export default app

// pour faire une API il faut specifier un proxy: "localhost" dans le package.json, et dans le fetch on peut mettre tout simplement de chemain après l'URL de localhost