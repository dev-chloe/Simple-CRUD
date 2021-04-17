# WEB on Next.js

## Dependency

### Init Next App

```bash
APP_NAME=web
npx create-next-app $APP_NAME --use-npm
```

### Install dependency

- [TypeScript](https://medium.com/@selvaganesh93/setup-next-js-with-typescript-integration-dece94e43cf5)
  
  ```bash
  npm install @zeit/next-typescript @types/next @types/react
  ```
  
  ```javascript
  // in next.config.js
  const withTypescript = require('@zeit/next-typescript')
  module.exports = withTypescript({
    webpack(config, options) {
      return config
    }
  })
  ```
  
  ```json
  // in .babelrc
  {
  "presets": ["next/babel", "@zeit/next-typescript/babel"]
  }
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
  
  - if use with typescript?
    ```javascript
    // in next.config.js
    const withTypescript = require('@zeit/next-typescript')
    const path = require('path')

    module.exports = withTypescript({
      webpack(config, options) {
        return config
      },
      sassOptions: {
        includePaths: [path.join(__dirname, 'Styles')],
      },
    })
    ```
