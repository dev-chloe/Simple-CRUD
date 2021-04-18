import registerStyle from '../css/register.module.scss'
import Link from 'next/link'

const inintialState = {
  name: '',
  email: '',
  password: ''
}

const Register = () => {
  return (
    <div className={registerStyle.container}>
      <h2>Register</h2>
      <form>
        {/* 
          TODO
          - custom input, 
          - email & required validate
          - input change handler
          - submit change handler
        */}
        <input type="text" placeholder="Name"/>
        <input type="password" placeholder="Password"/>
        <input type="text" placeholder="Email"/>
        <button type="submit">Submit</button>
        <Link href="">
          <a>Login</a>
        </Link>
      </form>
    </div>
  )
}

export default Register