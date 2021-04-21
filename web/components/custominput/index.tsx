import { useState } from 'react'

const Custominput =({
  type = 'text',
  name,
  placeholder = '',
  value,
  onChange = () => {},
  onBlur = () => {}
}) => {
  const [ error, setError ] = useState('');

  const headleBule = () => {
    const isValid = onBlur && onBlur(value);
    isValid ? setError('') : setError(`invalid ${name}`)
  }
  return (
    <>
      <input
        type={type}
        name={name}
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        onBlur={headleBule}
      ></input>
      
      { error && <p className="error">{error}</p> }
      </>
    )
}

export default Custominput