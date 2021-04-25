import indexStyle from '../css/index.module.scss'
import Link from 'next/link'

const IndexPage = () => (
  <div className={indexStyle.box}>
    <h1>Hello Next.js 👋</h1>
    <div className={indexStyle.btn_wrapper}>
      <Link href="/register">
        <a className={indexStyle.btn}>Register</a>
      </Link>
      <Link href="/login">
        <a className={indexStyle.btn}>Login</a>
      </Link>
    </div>
  </div>
)

export default IndexPage
