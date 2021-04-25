import {useState} from 'react'
import Link from 'next/link'

import registerStyle from '../css/register.module.scss'
import CustomInput from '../components/custominput'
import validateEmail from '../utils/validators/validateEmail'
import validateRequired from '../utils/validators/validateRequired'

const inintialState = {
  email: '',
  password: ''
}

const login = () => {
  const [ loginInfo, setLoginInfo ] = useState(inintialState)

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    setLoginInfo({
      ...loginInfo,
      [name]: value
    })
  }
  return (
    <div className={registerStyle.container}>
      <h2>Login</h2>
      <form>
        <CustomInput
          type="email"
          name="email"
          placeholder="Enter your email"
          value={loginInfo.email}
          onChange={handleInputChange}
          onBlur={validateEmail}
        ></CustomInput>
        <CustomInput
          type="password"
          name="password"
          placeholder="Enter your password"
          value={loginInfo.password}
          onChange={handleInputChange}
          onBlur={validateRequired}
          ></CustomInput>
          <button type="submit">Login</button>
          <Link href="/register">
            <a>Join</a>
          </Link>
      </form>
    </div>
  )
}

export default login