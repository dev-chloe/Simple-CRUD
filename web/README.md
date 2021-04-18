# WEB on Next.js

## Dependency

### Init Next App

```bash
APP_NAME=web
npx create-next-app $APP_NAME --use-npm
```

### Install dependency

- [TypeScript](https://github.com/vercel/next.js/tree/canary/examples/with-typescript#notes)
  
  ```bash
  npm install --save-dev typescript @types/react @types/react-dom @types/node
  ```

- [scss](https://nextjs.org/docs/basic-features/built-in-css-support#sass-support)
  
  ```bash
  npm install sass
  ```
  
  ```javascript
  // in next.config.js
  const path = require('path')
  module.exports = {
    sassOptions: {
      includePaths: [path.join(__dirname, 'styles')],
    },
  }
  ```
  
  - For global style: [/css/style.scss](./css/style.scss) + [/pages/_app.js](./pages/_app.js)
  
  - For page style: [/css/index.module.scss](./css/index.module.scss) + [/pages/index.js](./pages/index.js)
  
  - [Best Practice (by Vercel)](https://github.com/vercel/next-learn-starter/blob/master/typescript-final/pages/index.tsx#L3)
  
