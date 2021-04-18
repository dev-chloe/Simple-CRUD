import indexStyle from '../css/index.module.scss'
import Link from 'next/link'

const IndexPage = () => (
  <div className={indexStyle.box}>
    <h1>Hello Next.js 👋</h1>
    <Link href="/register">
      <a className={indexStyle.btn}>Register</a>
    </Link>
  </div>
)

export default IndexPage
