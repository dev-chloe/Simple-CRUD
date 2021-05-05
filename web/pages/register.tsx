import { useState } from 'react'
import { useRouter } from 'next/router'
import Link from 'next/link'

import registerStyle from '../css/register.module.scss'
import Custominput from '../components/custominput'
import validateEmail from '../utils/validators/validateEmail'
import validateRequired from '../utils/validators/validateRequired'


const inintialState = {
  name: '',
  email: '',
  password: ''
}

const Register = () => {
  const [ registerInfo, setRegisterInfo ] = useState(inintialState)
  const [ error, setError ] = useState('')
  const router = useRouter();

  const handleSubmit = async (e) => {
    e.preventDefault();

    const { email, password, name } = registerInfo

    if( !email || !password || !name ) {
      return
    }
    try {
      console.log('fin')
      router.replace('/login')
    } catch(error) {
      setError(error.message);
    }
  }

  const handleInputChange = (e) => {
    const { name, value } = e.target;

    setRegisterInfo({
      ...registerInfo,
      [name]: value
    })
  }

  return (
    <div className={registerStyle.container}>
      <h2>Register</h2>
      <form onSubmit={handleSubmit}>
        {/* 
          TODO
          - fix submit
        */}
        <Custominput
          type="name"
          name="name"
          placeholder="Enter your name"
          value={registerInfo.name}
          onChange={handleInputChange}
          onBlur={validateRequired}
        ></Custominput>
        <Custominput
          type="email"
          name="email"
          placeholder="Enter your email"
          value={registerInfo.email}
          onChange={handleInputChange}
          onBlur={validateEmail}
        ></Custominput>
        <Custominput
          type="password"
          name="password"
          placeholder="Enter your password"
          value={registerInfo.password}
          onChange={handleInputChange}
          onBlur={validateRequired}
        ></Custominput>
        <button type="submit">Submit</button>
        <Link href="/login">
          <a>Login</a>
        </Link>
      </form>
    </div>
  )
}

export default Register